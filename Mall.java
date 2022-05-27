import java.io.*;
class Mall implements Serializable{
	String prname;
	int prprice;
	int qantity;
	Mall(String name,int price){
		prname=name;
		prprice=price;
	}
}