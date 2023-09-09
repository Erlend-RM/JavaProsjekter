class Bil3{
  String bilnr;

  public void SkrivUt(){
  System.out.println("Bil nr: " + bilnr);
  }

  public Bil3(String n){
    bilnr = n;
  }

  public String HentNummer(){
    return bilnr;
  }
}
