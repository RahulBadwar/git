import java.util.Scanner;
import java.io.*;

class main implements Serializable {
    static LL gcd = new LL();// groccary
    static LL elc = new LL();// electonics
    static LL ftw = new LL();// footwear
    static LL str = new LL();// stationary
    static LL cos = new LL();// cosmetics
    static LL cart = new LL();// cart
    static LL save[] = new LL[20];
    static LL object[] = new LL[20];
    static int custumer_no;

    static {
        gcd.add("Sugar              ", 40);
        gcd.add("Wheat              ", 40);
        gcd.add("ToorDal            ", 80);
        gcd.add("Rice               ", 50);
        gcd.add("SoyabeanOil        ", 130);
        cos.add("Fogg Deo           ", 190);
        cos.add("Ponds Face         ", 137);
        cos.add("Joy Bodylotion     ", 240);
        cos.add("Garnier Shampoo    ", 120);
        cos.add("Bajaj AlmondOil    ", 185);
        str.add("Pen                ", 10);
        str.add("Notebook           ", 50);
        str.add("pencil             ", 15);
        str.add("calculator         ", 750);
        str.add("FileFolder         ", 140);
        ftw.add("Sparx1845          ", 1250);
        ftw.add("RedChief423        ", 4249);
        ftw.add("puma               ", 2999);
        ftw.add("bata               ", 999);
        ftw.add("RedTape23R         ", 1499);
        elc.add("Orientfan          ", 3499);
        elc.add("SyskaLED           ", 60);
        elc.add("BoatAirdopes       ", 1299);
        elc.add("Mi_4ALED           ", 22599);
        elc.add("SamsungRefrigerator", 16500);

    }

    static String adjust(String s) {
        int n = s.length();
        String s1 = " ";
        for (int i = n; i < 19; i++) {
            s = s + s1;
        }
        return s;
    }

    public static void main(String... args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        LL seecart;
        Scanner sc = new Scanner(System.in);
        int n = 0, ch, count1 = 0, count2 = 0;
        int custumer_no = 0;
        do {
            System.out.println("Welcome to java powered billing system.......");
            System.out.println(
                    "\nEnter your choice :\n1.Generate Bill.\n2.Display final bill.\n3.Add products. \n4.Save data of custmer.\n5.Print Bill of previous custemer.\n6 Save todays data.\n7.Fetch previous dyas data...\n8.Exit");

            n = sc.nextInt();

            switch (n) {

                case 1:
                    custumer_no++;
                    do {
                        if (count1 == 0) {
                            System.out.println("Catagoarys of products as follows");
                        } else {
                            System.out.println("Buy from other categories");
                        }
                        System.out.println("Genrating Bill for custmer " + custumer_no);

                        System.out.println(
                                "\n1.Grocery\n2.Cosmetics \n3.Electronics \n4.Stationary\n5.Footwear.\n6.EXIT");
                        System.out.println("Enter category of product");
                        count1++;
                        ch = sc.nextInt();
                        switch (ch) {
                            case 1:

                                gcd.displayCategories();// goes to displayCategories
                                Node temp = gcd.addCart();// for getting node of product
                                cart.addbynode(temp);//

                                break;
                            case 2:
                                cos.displayCategories();
                                temp = cos.addCart();
                                cart.addbynode(temp);

                                break;
                            case 3:
                                elc.displayCategories();
                                temp = elc.addCart();
                                cart.addbynode(temp);
                                break;
                            case 4:
                                str.displayCategories();
                                temp = str.addCart();
                                cart.addbynode(temp);
                                break;
                            case 5:
                                ftw.displayCategories();
                                temp = ftw.addCart();
                                cart.addbynode(temp);
                                break;

                        }
                    } while (ch != 6);
                    break;
                case 2:
                    cart.printbill();

                    // n=4;
                    break;
                case 3:
                    System.out.println("which store you want to update!!!!");
                    System.out.println("\n1.Grocery\n2.Stationery \n3.Footwears \n4.Cosmetics\n5.Electronics");
                    int x = sc.nextInt();
                    switch (x) {
                        case 1:
                            System.out.println("Enter product Name");
                            sc.nextLine();
                            String s1 = sc.nextLine();
                            System.out.println("Enter product price");
                            int p1 = sc.nextInt();
                            String s11 = adjust(s1);
                            gcd.add(s11, p1);

                            break;
                        case 2:
                            System.out.println("Enter product Name");
                            sc.nextLine();
                            s1 = sc.nextLine();
                            System.out.println("Enter product price");
                            p1 = sc.nextInt();
                            s11 = adjust(s1);
                            str.add(s11, p1);

                            break;
                        case 3:
                            System.out.println("Enter product Name");
                            sc.nextLine();
                            s1 = sc.nextLine();
                            System.out.println("Enter product price");
                            p1 = sc.nextInt();
                            s11 = adjust(s1);
                            ftw.add(s11, p1);

                            break;
                        case 4:
                            System.out.println("Enter product Name");
                            sc.nextLine();
                            s1 = sc.nextLine();
                            System.out.println("Enter product price");
                            p1 = sc.nextInt();
                            s11 = adjust(s1);
                            cos.add(s11, p1);

                            break;
                        case 5:
                            System.out.println("Enter product Name");
                            sc.nextLine();
                            s1 = sc.nextLine();
                            System.out.println("Enter product price");
                            p1 = sc.nextInt();
                            s11 = adjust(s1);
                            elc.add(s11, p1);

                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    LL copy = (LL) cart.clone();
                    save[custumer_no] = copy;
                    cart.head = null;
                    System.out.println("Bill for custemer number" + custumer_no + " saved succesfully...");
                    break;
                case 5:
                    System.out.println("Enter a custemer number ...");
                    int ccc = sc.nextInt();
                    if (ccc <= custumer_no) {
                        seecart = save[ccc];
                        seecart.printbill();
                    } else
                        System.out.println("Not shopped yet ...");
                    break;
                case 6:
                    System.out.println("TO save todays data");
                    // File f=new File("save.txt");

                    FileOutputStream fos = new FileOutputStream("save.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(save);
                    break;
                case 7:
                    System.out.println("Feching data...");
                    FileInputStream file = new FileInputStream("save.txt");
                    ObjectInputStream in = new ObjectInputStream(file);
                    object = (LL[]) in.readObject();
                    System.out.println("Enter a custemer number");
                    int aa = sc.nextInt();
                    LL cc = object[aa];
                    cc.printbill();
                    break;
                default:
            }
        } while (n != 9);

    }
}
