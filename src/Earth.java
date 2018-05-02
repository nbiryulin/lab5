import java.util.Random;
public class Earth  {

    Boolean issled;
    Random s = new Random();
    float radius = 6371;
    boolean liveexist = true;
    boolean water = true;
    int countfromsun = 3;
    long LoNg = Math.round(radius * 2.0 * Math.PI);
    boolean air = true;

    public void setIssled(Nothingknower x) {
        issled = true;
        x.issled = true;
        System.out.println("На планете " + getClass() + " " + "начались исследования");
    }

    public void explode() {
        System.out.println("BOOOM");
        System.exit(0);
    }

    public enum air {
        O2, N2
    }

    void method2() {
        class PERCENT {
            int[] PROC = {10, 90};

            void printV() {
                System.out.println(PROC[s.nextInt(2)]);
            }

        }
    }

    void g() {
        Earth x = new Earth() {
            void method1() {
                System.out.println("куку");
            }
        };
    }
}
