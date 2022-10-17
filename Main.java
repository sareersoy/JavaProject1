
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<Article> ArticlesArray = new ArrayList<Article>();
    private static Author[] AuthorsArray;
    public static void command_1(String a) {
        String[] lines = ReadFromFile.readFile(a);
        Article[] articles = new Article[lines.length];
        int i = 0;
        for (String line : lines) {
            String[] array = line.split(" ");
            Article obje = new Article(array[1], array[2], array[3], array[4]);
            articles[i] = obje;
            i++;
        }
        for (int j = 0; j < articles.length; j++) {
            ArticlesArray.add(articles[j]);
        }
    }

    public static void command_3(Author[] authorarray, ArrayList<Article> articlearrayy) {
        Article[] articlearray = new Article[articlearrayy.size()];
        for (int k = 0; k < articlearrayy.size(); k++) {
            articlearray[k] = articlearrayy.get(k);
        }

        int i = 0;
        for (Article article : articlearray) {
            for (Author author : authorarray) {
                try {
                    if (article.getPaperid().equals(author.getArticle1().getPaperid())) {
                        articlearray[i] = new Article();
                    } else if (article.getPaperid().equals(author.getArticle2().getPaperid())) {
                        articlearray[i] = new Article();
                    } else if (article.getPaperid().equals(author.getArticle3().getPaperid())) {
                        articlearray[i] = new Article();
                    } else if (article.getPaperid().equals(author.getArticle4().getPaperid())) {
                        articlearray[i] = new Article();
                    } else if (article.getPaperid().equals(author.getArticle5().getPaperid())) {
                        articlearray[i] = new Article();
                    }
                } catch (Exception e) {
                    System.out.print("");
                }


            }
            i++;
        }
        for (Author author : authorarray) {
            int y = 0;
            String id = author.getId();
            for (Article article : articlearray) {
                if (article.getPaperid().startsWith(id)) {
                    if (author.getArticle1().getPaperid().equals("0")) {
                        author.setArticle1(article);
                        articlearray[y] = new Article();
                        y++;
                        continue;
                    }
                    if (author.getArticle2().getPaperid().equals("0")) {
                        author.setArticle2(article);
                        articlearray[y] = new Article();
                        y++;
                        continue;
                    }
                    if (author.getArticle3().getPaperid().equals("0")) {
                        author.setArticle3(article);
                        articlearray[y] = new Article();
                        y++;
                        continue;
                    }
                    if (author.getArticle4().getPaperid().equals("0")) {
                        author.setArticle4(article);
                        articlearray[y] = new Article();
                        y++;
                        continue;
                    }
                    if (author.getArticle5().getPaperid().equals("0")) {
                        author.setArticle5(article);
                        articlearray[y] = new Article();
                        y++;
                        continue;
                    }

                }
                y++;
            }
        }
        ArrayList<Article> geciciarticlearray = new ArrayList<Article>();
        for (int c = 0; c < articlearray.length; c++) {
            geciciarticlearray.add(articlearray[c]);
        }
        ArticlesArray = geciciarticlearray;
        AuthorsArray = authorarray;
    }

    public static void command_4(Author[] authorarray) {
        for (Author author : authorarray) {
            int sayi = 0;
            if (!(author.getArticle1().getPaperid().equals("0"))) {
                sayi++;
                if (!(author.getArticle2().getPaperid().equals("0"))) {
                    sayi++;
                    if (!(author.getArticle3().getPaperid().equals("0"))) {
                        sayi++;
                        if (!(author.getArticle4().getPaperid().equals("0"))) {
                            sayi++;
                            if (!(author.getArticle5().getPaperid().equals("0"))) {
                                sayi++;
                            }
                        }
                    }
                }
            }

            int[] paperidarray = new int[sayi];
            for (int i = 0; i < sayi; i++) {
                if ((Integer.parseInt(author.getArticle(i))) != 0) {
                    paperidarray[i] = Integer.parseInt(author.getArticle(i));

                } else {
                    break;
                }
            }
            Arrays.sort(paperidarray);
            Article[] personalarticle = new Article[paperidarray.length];
            for (int id : paperidarray) {
                for (int i = 0; i < paperidarray.length; i++) {
                    if (1 <= paperidarray.length && author.getArticle1().getPaperid().equals(String.valueOf(paperidarray[i]))) {
                        personalarticle[i] = author.getArticle1();
                    } else if (2 <= paperidarray.length && author.getArticle2().getPaperid().equals(String.valueOf(paperidarray[i]))) {
                        personalarticle[i] = author.getArticle2();
                    } else if (3 <= paperidarray.length && author.getArticle3().getPaperid().equals(String.valueOf(paperidarray[i]))) {
                        personalarticle[i] = author.getArticle3();
                    } else if (4 <= paperidarray.length && author.getArticle4().getPaperid().equals(String.valueOf(paperidarray[i]))) {
                        personalarticle[i] = author.getArticle4();
                    } else if (5 <= paperidarray.length && author.getArticle5().getPaperid().equals(String.valueOf(paperidarray[i]))) {
                        personalarticle[i] = author.getArticle5();
                    }

                }
            }
            for (int i = 0; i < personalarticle.length; i++) {
                author.setArticle(i + 1, personalarticle[i]);

            }

        }
        AuthorsArray = authorarray;
    }

    public static void command_5(int id) {
        ArrayList<Author> geciciauthorarraylist = new ArrayList<Author>();


        for (Author author : AuthorsArray) {
            if (!author.getId().equals(String.valueOf(id))) {
                geciciauthorarraylist.add(author);
            }
        }
        Author[] geciciauthorarray = new Author[geciciauthorarraylist.size()];
        int i = 0;
        for (Author author : geciciauthorarraylist) {
            geciciauthorarray[i] = author;
            i++;
        }
        AuthorsArray = geciciauthorarray;

    }

    public static Author[] makeAuthorArray(ArrayList<Article> articlearrayy, String arg) {
        Article[] articlearray = new Article[articlearrayy.size()];
        for (int i = 0; i < articlearray.length; i++) {
            articlearray[i] = articlearrayy.get(i);
        }
        String[] authors = ReadFromFile.readFile(arg);
        Author[] authorsArray = new Author[authors.length];
        int z = 0;
        for (String author : authors) {
            String[] authorlinee = author.split(" ");
            String[] authorline = new String[11];
            int in = 0;
            for(String instance: authorlinee){
                authorline[in]=instance;
            in++;
            }
            if(authorlinee.length==2){
                authorline[2]="";
                authorline[3]="";
                authorline[4]="";
                authorline[5]="";
            }
            Author authorobj = new Author(authorline[1], authorline[2], authorline[3], authorline[4], authorline[5]);


            for (int m = 0; m < articlearray.length; m++) {
                if (7 <= authorline.length && articlearray[m].getPaperid().equals(authorline[6])) {
                    authorobj.setArticle1(articlearray[m]);
                } else if (8 <= authorline.length && articlearray[m].getPaperid().equals(authorline[7])) {
                    authorobj.setArticle2(articlearray[m]);
                } else if (9 <= authorline.length && articlearray[m].getPaperid().equals(authorline[8])) {
                    authorobj.setArticle3(articlearray[m]);
                } else if (10 <= authorline.length && articlearray[m].getPaperid().equals(authorline[9])) {
                    authorobj.setArticle4(articlearray[m]);
                } else if (11 <= authorline.length && articlearray[m].getPaperid().equals(authorline[10])) {
                    authorobj.setArticle5(articlearray[m]);
                }

            }
            authorsArray[z] = authorobj;
            z++;
        }
        AuthorsArray = authorsArray;
        return AuthorsArray;
    }

    public static void main(String[] args) throws IOException {

        try (FileWriter writer = new FileWriter("output.txt")) {
        String[] commands = ReadFromFile.readFile(args[1]);
        int authoraaraysayaci=0;
        for(String command: commands) {
            if (command.startsWith("read")) {
                String[] readarray = command.split(" ");

                command_1(readarray[1]);
            } else if (command.startsWith("list")) {
                writer.write("--------------------------------------------------List--------------------------------------------------\n");
                if (authoraaraysayaci == 0) {
                    makeAuthorArray(ArticlesArray,args[0]);
                    authoraaraysayaci++;
                }


                for (Author author : AuthorsArray) {
                    writer.write("\nAuthor:" + author.getId() + "\t" + author.getName() + "\t" + author.getUniversity() + "\t" + author.getDepartment() + "\t" + author.getEmail()+"\n");
                    try {
                        if(author.getArticle1().getPaperid().equals("0")){
                            continue;
                        }
                        else{
                            writer.write("+");
                            writer.write(author.getArticle1().getPaperid() + "\t" + author.getArticle1().getName() + "\t" + author.getArticle1().getPublisherName() + "\t" + author.getArticle1().getPublishYear());
                            writer.write("\n");}
                    } catch (Exception e) {
                        writer.write(" ");
                    }
                    try {
                        if(author.getArticle2().getPaperid().equals("0")){
                            continue;

                        }
                        else {
                            writer.write("+");
                            writer.write(author.getArticle2().getPaperid() + "\t" + author.getArticle2().getName() + "\t" + author.getArticle2().getPublisherName() + "\t" + author.getArticle2().getPublishYear());
                            writer.write("\n");
                        }
                    } catch (Exception e) {
                        writer.write(" ");
                    }
                    try {
                        if(author.getArticle3().getPaperid().equals("0")){
                            continue;
                        }
                        else {
                            writer.write("+");
                            writer.write(author.getArticle3().getPaperid() + "\t" + author.getArticle3().getName() + "\t" + author.getArticle3().getPublisherName() + "\t" + author.getArticle3().getPublishYear());
                            writer.write("\n");
                        }
                    } catch (Exception e) {
                        writer.write(" ");
                    }
                    try {
                        if(author.getArticle4().getPaperid().equals("0")){
                            continue;
                        }
                        else {
                            writer.write("+");
                            writer.write(author.getArticle4().getPaperid() + "\t" + author.getArticle4().getName() + "\t" + author.getArticle4().getPublisherName() + "\t" + author.getArticle4().getPublishYear());
                            writer.write("\n");
                        }
                    } catch (Exception e) {
                        writer.write(" ");
                    }
                    try {
                        if(author.getArticle5().getPaperid().equals("0")){
                            continue;
                        }
                        else {
                            writer.write("+");
                            writer.write(author.getArticle5().getPaperid() + "\t" + author.getArticle5().getName() + "\t" + author.getArticle5().getPublisherName() + "\t" + author.getArticle5().getPublishYear());
                            writer.write("\n");
                        }
                    } catch (Exception e) {
                        System.out.print(" ");
                    }

                }

                writer.write("--------------------------------------------------End--------------------------------------------------\n");
            } else if (command.startsWith("completeAll")) {
                if (authoraaraysayaci == 0) {
                    command_3(makeAuthorArray(ArticlesArray,args[0]), ArticlesArray);
                    authoraaraysayaci++;
                } else {
                    command_3(AuthorsArray, ArticlesArray);
                }
                writer.write("****************************************CompleteAll Successful****************************************\n");
            } else if (command.startsWith("sortedAll")) {
                if (authoraaraysayaci == 0) {
                    command_4(makeAuthorArray(ArticlesArray,args[0]));
                } else {
                    command_4(AuthorsArray);
                }
                writer.write("****************************************SortedAll Successful****************************************\n");
            } else if (command.startsWith("del")) {
                String[] readarray = command.split(" ");
                if (authoraaraysayaci == 0) {

                    makeAuthorArray(ArticlesArray,args[0]);
                    command_5(Integer.parseInt(readarray[1]));
                    authoraaraysayaci++;
                } else {
                    command_5(Integer.parseInt(readarray[1]));
                }
                writer.write("****************************************del Successful****************************************\n");
            }



        }
            writer.close();}
        catch(Exception e){
            System.out.print("Buna hazırlıklı gelmemişim hocam...");
            }

        }

    }




