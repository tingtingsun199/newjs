
public class Game {
	
		
		public static void main(String[] args) {
			//1.����һ��1-100�������
			// �������
			   java.util.Random random =
					   new java.util.Random();
			 // ���㿪ʼ
			   int randomNumber=random.nextInt(100)+1;
			   //System.out.println(randomNumber);
			//2.����һ���������
			java.util.Scanner sc=
					new java.util.Scanner(System.in);
			//3.���û�����
			System.out.println("��    ����һ������");
			//�������
			int count = 5;
			while (true) {
				if(count<1)
				{
					System.out.println("ɵ�˰ɣ�����"+randomNumber);
					break;//�˳�
				}else
				//��������
				System.out.println("�㻹��"+count+"�λ���");
				count--;
			
				int inputNumber = sc.nextInt();
				
			    
				
				//4.�ж�
				if (inputNumber > randomNumber) {
					//4.1 ������ʾ: ������̫����
					System.out.println("С��ң�̫����");
				} else if (inputNumber < randomNumber) {
					//4.2 С������: ���ϣ���С��
					System.out.println("������̫С��");
				} else {
					//4.3���ڣ�ʲô���������ˣ���Ȼ�¶���
					System.out.println("ʲô�����������ˣ���Ȼ�¶���");
					break;
				}
			}
			
			
		}

	}


