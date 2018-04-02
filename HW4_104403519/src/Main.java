/*** 
 * @Author 侯凱翔
 * 學號: 104403519
 * 系級: 資管3A
 * HW4: 求質因數
***/
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
	    int count =0; //用來計算共幾個質因數
		Set<Integer> numbers = new HashSet<>(); //把求出來的質因數放進這個Hashset
		
		while(true) { //需可重複執行，所以用while
			try {
				String read = JOptionPane.showInputDialog(null,"請輸入一整數:","找質因數",JOptionPane.INFORMATION_MESSAGE);
				if(read != null){ //若讀到的回傳值不為null，則進行運算
					int x = Integer.parseInt(read); //把讀到的轉為int進行運算
					//判斷輸入條件
					if(x<0){ //輸入負數
						JOptionPane.showMessageDialog(null, "只能輸入正整數!!!","輸入錯誤!!!",JOptionPane.INFORMATION_MESSAGE);
					}
					if(x==0 || x==1) { //特殊情況:輸入0或1
						JOptionPane.showMessageDialog(null, x+"不是質數也沒有質因數喔!","結果",JOptionPane.INFORMATION_MESSAGE);
					}
					if(x>=2) {
						//找出質因數
						for(int i=2; i<x; i++){ 
							if(x%i==0){ //餘數=0表示整除 
								boolean check = true; //預設目前讀到的i是質數 
								for(int j=2; check && j<i; j++){
									if(i%j==0){ // 這個i表示不是質數，所以不會是質因數 
									check = false; 
									} 
								}
								if(check){ 
									numbers.add(i);
									count++;
								}
							}
						}
						//顯示結果
						if(numbers.isEmpty() && x!=0 && x!=1) { //表輸入的數是質數
							JOptionPane.showMessageDialog(null, x+"是個質數!", "結果",JOptionPane.INFORMATION_MESSAGE);
							JOptionPane.showMessageDialog(null,"共"+count+"個質因數",x+"的質因數個數",JOptionPane.INFORMATION_MESSAGE);
						}
						else { //輸入的不是質數，顯示其質因數
							Set<Integer> ts = new TreeSet<>(numbers); //將HashSet轉為TreeSet做排序
							Iterator iterator = ts.iterator(); //利用TreeSet的iterator印出質因數
							int c=1; //用來表示視窗Title中的第幾個質因數
							while(iterator.hasNext()) {
								JOptionPane.showMessageDialog(null,x+"的質因數有:"+iterator.next(),"質因數"+c+"/"+count,JOptionPane.INFORMATION_MESSAGE);
								c++;
							}
							JOptionPane.showMessageDialog(null,"共"+count+"個質因數",x+"的質因數個數",JOptionPane.INFORMATION_MESSAGE);
							// 做完了，把值回歸以做下次重新執行
							c = 1;
							count = 0;
							numbers.clear();
						}
					}
				}
				else { //若讀到的回傳值為null，則關閉程式
					System.exit(0);
					}
			}
			catch(NumberFormatException ex){ //抓輸入不符合規定的exception (空白,小數 或 String)
				JOptionPane.showMessageDialog(null, "只能輸入正整數!!!","輸入錯誤!!!",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
