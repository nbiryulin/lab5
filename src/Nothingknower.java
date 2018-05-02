public class Nothingknower implements Breathe {
    boolean Habit;
    String name="NEZNAYKA";
    heart p=new heart();
    Boolean issled=false;
    Boolean br;
    int height;
    int weight;
    spacesuit y=new spacesuit();
    int age;
    boolean suit=false;
    void cross(Earth x) throws GoException {

        System.out.println("Начал исследовать");
        for(long i=0;i<x.LoNg;i=i+100){
            if(i>=1000){ throw new GoException();}

            System.out.println("Иду");
        }
        System.out.println("Я пришел");

    }
    void laugh(){System.out.println("Хахаха");}
    void think(){System.out.println("Всем Привет!");}
    void mindprison(String s){System.out.println("Умозаключение - "+" "+s);}
    void takeon(){ suit=true;
        y.on=true;
        System.out.println("Надел костюм");

    }
    void takeoff(){suit=false;
        y.on=false;
        System.out.println("Снял костюм");
    }

    public void exhale(Earth c){br=false;}
    public void breathin(Earth c){

        if (!(c.air||suit)){
            p.bps=0;

            System.exit(0);}else{br=true;
            p.beat();}
    }
    public boolean equals(Object obj) {

        if (obj==null||obj.getClass()!=this.getClass()||obj.hashCode()!=this.hashCode()) {return false;}

        Nothingknower guest = (Nothingknower)obj;
        return  age==guest.age&& (name == guest.name ||
                (name != null && name.equals(guest.name)))
                && (height == guest.height || (weight ==guest.weight));
    }


    @Override
    public int hashCode() {
        try {if (age==0)throw new StupidException();}catch(Exception e) {
            e.printStackTrace();}
        int kk = name.hashCode() *height*weight/age;
        return kk;
    }
    @Override
    public String toString() {
        return "Вес " +weight;
    }}
