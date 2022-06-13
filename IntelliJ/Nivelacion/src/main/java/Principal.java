public class Principal {
    public static void main(String[] args) {

        int n1 = 23;
        int n2 = 20;


        switch (n1) {
            case 19:
                System.out.print("Entro");
                break;
            case 20, 21, 22: {
                System.out.print("Entro");
                break;
            }
            default:
                System.out.print("No hubo coincidencia");
                break;
        }
    }
}
