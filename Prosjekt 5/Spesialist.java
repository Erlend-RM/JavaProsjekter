public class Spesialist extends Lege implements Godkjenningsfritak{
    protected String KontrollId;

    public Spesialist(String navn, String KontrollId){
        super(navn);
        this.KontrollId = KontrollId;
    }

    @Override
    public String hentKontrollID(){
        return KontrollId;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + "KontrollId på lege: " + KontrollId;
    }
}
