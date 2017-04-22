package sample;


public class GetAns {

    public FindAns find = new FindAns();

    public boolean connection() {
        return find.isDbConnected();
    }

    public String ans(String q) {
        try{
            return find.returnAns(q);
        }catch(Exception e) {

            e.printStackTrace();
            return "failed at gA Class";
        }
    }
}
