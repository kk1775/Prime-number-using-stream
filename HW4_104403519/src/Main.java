/*** 
 * @Author �J�͵�
 * �Ǹ�: 104403519
 * �t��: ���3A
 * HW4: �D��]��
***/
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
	    int count =0; //�Ψӭp��@�X�ӽ�]��
		Set<Integer> numbers = new HashSet<>(); //��D�X�Ӫ���]�Ʃ�i�o��Hashset
		
		while(true) { //�ݥi���ư���A�ҥH��while
			try {
				String read = JOptionPane.showInputDialog(null,"�п�J�@���:","���]��",JOptionPane.INFORMATION_MESSAGE);
				if(read != null){ //�YŪ�쪺�^�ǭȤ���null�A�h�i��B��
					int x = Integer.parseInt(read); //��Ū�쪺�ରint�i��B��
					//�P�_��J����
					if(x<0){ //��J�t��
						JOptionPane.showMessageDialog(null, "�u���J�����!!!","��J���~!!!",JOptionPane.INFORMATION_MESSAGE);
					}
					if(x==0 || x==1) { //�S���p:��J0��1
						JOptionPane.showMessageDialog(null, x+"���O��Ƥ]�S����]�Ƴ�!","���G",JOptionPane.INFORMATION_MESSAGE);
					}
					if(x>=2) {
						//��X��]��
						for(int i=2; i<x; i++){ 
							if(x%i==0){ //�l��=0��ܾ㰣 
								boolean check = true; //�w�]�ثeŪ�쪺i�O��� 
								for(int j=2; check && j<i; j++){
									if(i%j==0){ // �o��i��ܤ��O��ơA�ҥH���|�O��]�� 
									check = false; 
									} 
								}
								if(check){ 
									numbers.add(i);
									count++;
								}
							}
						}
						//��ܵ��G
						if(numbers.isEmpty() && x!=0 && x!=1) { //���J���ƬO���
							JOptionPane.showMessageDialog(null, x+"�O�ӽ��!", "���G",JOptionPane.INFORMATION_MESSAGE);
							JOptionPane.showMessageDialog(null,"�@"+count+"�ӽ�]��",x+"����]�ƭӼ�",JOptionPane.INFORMATION_MESSAGE);
						}
						else { //��J�����O��ơA��ܨ��]��
							Set<Integer> ts = new TreeSet<>(numbers); //�NHashSet�ରTreeSet���Ƨ�
							Iterator iterator = ts.iterator(); //�Q��TreeSet��iterator�L�X��]��
							int c=1; //�ΨӪ�ܵ���Title�����ĴX�ӽ�]��
							while(iterator.hasNext()) {
								JOptionPane.showMessageDialog(null,x+"����]�Ʀ�:"+iterator.next(),"��]��"+c+"/"+count,JOptionPane.INFORMATION_MESSAGE);
								c++;
							}
							JOptionPane.showMessageDialog(null,"�@"+count+"�ӽ�]��",x+"����]�ƭӼ�",JOptionPane.INFORMATION_MESSAGE);
							// �����F�A��Ȧ^�k�H���U�����s����
							c = 1;
							count = 0;
							numbers.clear();
						}
					}
				}
				else { //�YŪ�쪺�^�ǭȬ�null�A�h�����{��
					System.exit(0);
					}
			}
			catch(NumberFormatException ex){ //���J���ŦX�W�w��exception (�ť�,�p�� �� String)
				JOptionPane.showMessageDialog(null, "�u���J�����!!!","��J���~!!!",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
