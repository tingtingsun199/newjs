
public class Game {
	
		
		public static void main(String[] args) {
			//1.产生一个1-100的随机数
			// 随机对象
			   java.util.Random random =
					   new java.util.Random();
			 // 从零开始
			   int randomNumber=random.nextInt(100)+1;
			   //System.out.println(randomNumber);
			//2.产生一个输入对象
			java.util.Scanner sc=
					new java.util.Scanner(System.in);
			//3.让用户输入
			System.out.println("亲    输入一个数字");
			//定义次数
			int count = 5;
			while (true) {
				if(count<1)
				{
					System.out.println("傻了吧，答案是"+randomNumber);
					break;//退出
				}else
				//次数限制
				System.out.println("你还有"+count+"次机会");
				count--;
			
				int inputNumber = sc.nextInt();
				
			    
				
				//4.判断
				if (inputNumber > randomNumber) {
					//4.1 大于提示: 辣鸡，太大了
					System.out.println("小婊砸，太大了");
				} else if (inputNumber < randomNumber) {
					//4.2 小于提升: 智障，有小了
					System.out.println("笨蛋，太小了");
				} else {
					//4.3等于：什么，大清亡了，居然猜对了
					System.out.println("什么，你做娘娘了，居然猜对了");
					break;
				}
			}
			
			
		}

	}


