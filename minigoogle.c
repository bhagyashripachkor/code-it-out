#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>

typedef struct {
  char *keyword;
  char **urls;
  int *freq;
  int urlcount;
}Dictionary;

Dictionary dictionary[10000];


/* Get_Page method returns the content of web page.
Input argument to this function is seed url i.e index.html
*/
char * get_page(char *url)
{
  char *input;
  int i=0;
  char c;
  
  FILE *fp;
  input=(char *)malloc(sizeof(char)*100000000);
  fp=fopen(url,"r");
  if(fp==NULL)
  {
    printf("unable to find the file");
   
  }
  else
   {
 
  
    while((c=fgetc(fp))!=EOF)
    {
      input[i++]=c;
     

      if((i%10)==0)
        input=(char *)realloc(input,sizeof(char)*(i+10));

    }

    input[i]='\0';
    
  }
  fclose(fp);
  return input;
  

}

/* get_next_target function gets the next url .
Input to this function is the string that contains all the content from html page starting from first <a href tag
It returns the link to get_all_links method
*/
char * get_next_target(char * string)
{
int i,len=0,len1,diff;
FILE *fp;

char *input,*link,*getLink,*close,*result,*sub;

link=string+9;
len=strlen(link);
close=strstr(link,"\"");
len1=strlen(close);
diff=len-len1;
result=(char *)malloc(sizeof(char*)*15000000);
strncpy(result,link,diff);
// printf("\n%s",result);

return result;
}

/*get_all_links recursively calls the get_next_target to get all the links from the html page and the respective links found in other html page
Input to this function is the page content
It returns all the set of links present in all html file 
*/
char **get_all_links(char * content)
{
  
  char **next_link,*string,*sub;
  int count=0,j,i;
  string=(char *)malloc(sizeof(char*)*10000000);
  next_link=(char **)malloc(sizeof(char*)*10000000);
  string=strstr(content,"<a href=");
  while(string!=NULL)
  {

  next_link[count]=get_next_target(string);
  
  sub=strstr(string,"\">");
  string=strstr(sub,"<a href=");
  count++;
  }
 
  next_link[count]=NULL;
  printf("\nAll links\n");
  for(i=0;next_link[i]!=NULL;i++)
  printf("\n%s",next_link);
  return next_link;
  free(string);
  free(next_link);
}

/*web_crawl functions calls the page content and all_links function recursively
Input to this fucntion is the seed url
Out of this is all links excluding the repetative links
*/
char ** web_crawl(char *url)
{
   int first=0,i=0;
   char **finalURLs,*page_content,**all_links;
   

  finalURLs=(char**)(malloc(sizeof(char*)*5000000));
  page_content=(char*)(malloc(sizeof(char*)*500000));
  all_links=(char**)(malloc(sizeof(char*)*500000));

  finalURLs[0] =url;
  
  finalURLs[1] = NULL;
  
  int last = 1,check=0,j;

  for(first=0; finalURLs[first]; first++) 
  {
    printf("\nSource url:-%s",finalURLs[first]);
    page_content = get_page(finalURLs[first]);
    
    all_links = get_all_links(page_content);
    

    
    for(i=0; all_links[i]; i++)
    {
     
        for(check=0,j=0;finalURLs[j]!=NULL;j++)
        {
        
          if(strcmp(finalURLs[first],all_links[i])==0)
          {
            check=1;
            break;
          }
       }
          if(check==0)
          {
              finalURLs[last] = all_links[i];
              
              last++;
              
          }
          finalURLs[last] ='\0';
      

    }
      for(i=0;finalURLs[i]!=NULL;i++)
        printf("\n%s",finalURLs[i]);
     return finalURLs;
  }
  
free(finalURLs);
free(page_content);
free(all_links);
}
/* get_stopwords function get all the stopwords stored in the html file.
*/
char **get_stopwords()
{
  int i=0;
  FILE *fp;
  fp=fopen("stopwords.txt","r");
  char **stopwords;
  if(fp==NULL)
    printf("no file found");
  else 
  {
    stopwords = (char **)malloc(sizeof(char *) * 1000000);
    while(!feof(fp)) 
    {
      stopwords[i] = (char *) malloc(100000);
      fscanf(fp, "\n%s", stopwords[i]);
      i++;
    }
  }
  stopwords[i] = NULL;
  return stopwords;
}

/* get_keywords funtion returns all the keyword excluding the stopwords in the html file.
The url is passed as an argument and compares each word with the word in  stopword file.
If match is found then exclude the word and returns only keyword
*/
char **get_keywords(char *url)
{
  char ch,**words,**stopwords,*token,**all_key_words;
  char *string = (char *) malloc(sizeof(char) * 50000000);
  int i=0, check=0, count=0,no_of_words=0,y=0,k=0,x=0,j=0;
  char **keywords;
  char *page_content = get_page(url);
  //cheks for spaces ,< and > tags in the file
  
  for(i=0 ; page_content[i] ; i++)
  {
    if(page_content[i] == '<')
      check = 1;
    else if(page_content[i]=='>')
      check=0;
      else if(isspace(page_content[i]))
      {
      while(isspace(page_content[i]))   
        i++;
      i--;
      }
    else if(isalpha(page_content[i]) && check!=1 )
    {
      while(isalpha(page_content[i]) && check!=1 )
        string[count++]= page_content[i++];

      string[count++] = ' ';
      no_of_words++;
      i--;
    }
  }
    
  token = strtok(string," ");
  words = (char **)malloc(sizeof(char *) * no_of_words+1 );
  if(words==NULL)
  {
    printf("Not enough memory");
  }
  
  for(y=0;token!=NULL;y++)
  {
    if(words==NULL)
      printf("\n Not enough memory");
    else
    {
    words[y] = (char *) malloc(sizeof(char) * strlen(token)+1);
    strcpy(words[y],token);
    token = strtok(NULL," ");
    }
  }
   words[y] = NULL;
  
    stopwords = get_stopwords();
  //below functions checks all the words from html file with stopwords
  
  all_key_words=(char **)malloc(sizeof(char*)*10000000);
  while(words[x]!=NULL)
  {  
    for(j=0; stopwords[j] ; j++)
      if(strcmpi(stopwords[j], words[x])==0)
        break;
    if(stopwords[j] == NULL)
     {
      all_key_words[k] = (char *)malloc(sizeof(char)*strlen(words[x])+1);
      strcpy(all_key_words[k] , words[x]) ;
      k++;
     }
     x++;
   }
   all_key_words[k]=NULL;
   // for(i=0;all_key_words[i]!=NULL;i++)
   //  printf("\n%s",all_key_words[i]);
   return all_key_words;
}

int checkKeywordInDictionary(char *keyword) {
  int index;
  for( index=0; dictionary[index].keyword!=NULL ; index++)
    if(strcmp(dictionary[index].keyword , keyword) == 0) 
      break;
  if(dictionary[index].keyword == NULL)
    return -1;
  else
    return index;
}

int checkURLInDictionary(int index, char *url) 
{
  int j;
  for(j=0; dictionary[index].urls[j]!=NULL ; j++)
    if(strcmp(dictionary[index].urls[j] , url ) == 0 )
      break;
  if(dictionary[index].urls[j]==NULL)
    return -1;
  else
    return j;
}

int dindex = 0;
char add_to_index(char *keyword , char *url) {
  int kwindex, urlindex;
  
  if(dindex==0) {
    //dictionary = (Dictionary *)malloc(sizeof(Dictionary) * 200);
    Dictionary dictionaryEntery;
    dictionaryEntery.keyword = (char *)malloc(sizeof(char) * 20);
    dictionaryEntery.keyword = keyword;
    dictionaryEntery.urls = (char **)malloc(sizeof(char *)*100);
    dictionaryEntery.urls[0] = url;
    dictionaryEntery.urls[1] = NULL;
    dictionaryEntery.freq = (int *)malloc(sizeof(int) * 100);
    dictionaryEntery.freq[0] = 1;
    dictionaryEntery.freq[1] = -1;
    dictionaryEntery.urlcount = 1;
    dictionary[dindex++] = dictionaryEntery;
  } else {
    kwindex = checkKeywordInDictionary(keyword);
    if(kwindex==-1) {
      //dictionary = (Dictionary *)
      //    realloc(dictionary, 100);
      // if(dictionary==NULL)
      //  printf("\n Memory alloc error");
      Dictionary dictionaryEntery;
      dictionaryEntery.keyword = (char *)malloc(sizeof(char) * 20);
      dictionaryEntery.keyword = keyword;
      dictionaryEntery.urls = (char **)malloc(sizeof(char *)*100);
      dictionaryEntery.urls[0] = url;
      dictionaryEntery.urls[1] = NULL;
      dictionaryEntery.freq = (int *)malloc(sizeof(int) * 100);
      dictionaryEntery.freq[0] = 1;
      dictionaryEntery.freq[1] = -1;
      dictionaryEntery.urlcount = 1;
      dictionary[dindex++] = dictionaryEntery;
    } else {
      urlindex = checkURLInDictionary(kwindex, url);
      if(urlindex==-1) {
        //dictionary[kwindex].urls = (char **) 
            //realloc(dictionary[kwindex].urls, 
            //  2000);
        dictionary[kwindex].urls[dictionary[kwindex].urlcount] = url;
        dictionary[kwindex].urls[dictionary[kwindex].urlcount+1] = NULL;
        dictionary[kwindex].freq[dictionary[kwindex].urlcount] = 1;
        dictionary[kwindex].freq[dictionary[kwindex].urlcount+1] = -1;
        dictionary[kwindex].urlcount++;
      } else {
        dictionary[kwindex].freq[urlindex]++;
      }
    }
  } 
}

void printDictionary() {
 FILE *fp = fopen("Dictionary.txt","w");
 if(fp==NULL) {
   printf("File Open error");
 } else {
   for(int i=0; i<dindex; i++) {
     // printf("%d\n",dindex);
     fprintf(fp, "\n::%s::", dictionary[i].keyword);
     //fprintf(fp, "\n::%d::", dictionary[i].urlcount);
     for(int j=0; j<dictionary[i].urlcount; j++) 
       fprintf(fp, "\n::%s::%d::", dictionary[i].urls[j], dictionary[i].freq[j]);
   }
   fclose(fp);
 }
}



void searchDictionary(char *searchString) {
  int index;
  for( index=0; dictionary[index].keyword!=NULL ; index++)
    if(strcmpi(dictionary[index].keyword , searchString) == 0) 
      break;
  if(dictionary[index].keyword==NULL)
    printf("No URLs found");
  else {
    for(int i=0; i< dictionary[index].urlcount; i++) 
    {
      for(int j=0 ; j<dictionary[index].urlcount ; j++)
      {
        if(dictionary[index].freq[i] > dictionary[index].freq[j])
        {
          int temp;
          temp=dictionary[index].freq[i];
          dictionary[index].freq[i]= dictionary[index].freq[j];
          dictionary[index].freq[j]= temp;
          char tem[50];
          strcpy(tem , dictionary[index].urls[i]);
          strcpy(dictionary[index].urls[i],dictionary[index].urls[j]);
          strcpy( dictionary[index].urls[j], tem);
        }
      }

    }
    for(int i=0; i< dictionary[index].urlcount; i++)
    printf("URL is : %s::%d\n", dictionary[index].urls[i] , dictionary[index].freq[i]);

  }
}

char *add_pages_to_index(char **urls)
{
  int j=0;
  
  for(j=0;urls[j]!=NULL;j++)
  printf("\n%s",urls[j]);
  for(int i=0; urls[i]!=NULL; i++)
   {
    char **keywords = get_keywords(urls[i]);
    for(j=0; keywords[j]!= NULL ; j++)
      add_to_index(keywords[j] , urls[i]) ;
  }
}

int main()
{

  char **urls,**finalURLs ;
  int i;
  char seed_url[50] = "Homepage.html";
  urls = web_crawl(seed_url);
   for(i=0;finalURLs[i]!=NULL;i++)
        printf("\n%s",finalURLs[i]);
  add_pages_to_index(urls);
  printDictionary();
  char *searchString = (char *) malloc(sizeof(char) * 100 );
  fflush(stdin);
  printf("\nenter the word to be searched ");
  gets(searchString);
  searchDictionary(searchString);
  return 0;
}

  
