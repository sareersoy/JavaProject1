public class Author {

    private String id;
    private String name;
    private String university;
    private String department;
    private String email;
    private Article article1;
    private Article article2;
    private Article article3;
    private Article article4;
    private Article article5;


    public Author(String id, String name, String university, String department, String email) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.email = email;
        this.article1 = new Article();
        this.article2 = new Article();
        this.article3 = new Article();
        this.article4 = new Article();
        this.article5 = new Article();
    }
    public String getArticle(int sayi) {
        String a = null;
         if(sayi == 0){
             a=article1.getPaperid();
         }
         else if(sayi==1){
                 a=article2.getPaperid();
             }
         else if(sayi==2){
             a=article3.getPaperid();
         }
         else if(sayi==3){
             a=article4.getPaperid();
         }
         else if(sayi==4){
             a=article5.getPaperid();
         }

         return a;
    }
public void setArticle(int sayi, Article article){
    if(sayi == 1){
        this.article1=article;
    }
    else if(sayi==2){
        this.article2=article;
    }
    else if(sayi==3){
        this.article3=article;
    }
    else if(sayi==4){
        this.article4=article;
    }
    else if(sayi==5){
        this.article5=article;
    }

}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Article getArticle1() {
        return article1;
    }

    public void setArticle1(Article article1) {
        this.article1 = article1;
    }

    public Article getArticle2() {
        return article2;
    }

    public void setArticle2(Article article2) {
        this.article2 = article2;
    }

    public Article getArticle3() {
        return article3;
    }

    public void setArticle3(Article article3) {
        this.article3 = article3;
    }

    public Article getArticle4() {
        return article4;
    }

    public void setArticle4(Article article4) {
        this.article4 = article4;
    }

    public Article getArticle5() {
        return article5;
    }

    public void setArticle5(Article article5) {
        this.article5 = article5;
    }
}