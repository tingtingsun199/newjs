package edu.software.compile;

import java.io.BufferedReader;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  


	
	/**  
	 * 1 ������  
	 * 2 ��ʶ��   
	 * 3 ����    
	 * 4 ���  
	 * 5 ���  
	 */  
	  
	public class Compile2 {  
	      
	    public int ch;  
	    public int code;//������״̬��  
	      
	    public StringBuffer strToken = new StringBuffer();//��Ź��ɵ��ʷ��ŵ��ַ���  
	      
	    public String [] retainWord = new String[]{"int","if","else","return","main","void","while","break"};//������  
	      
	    //�ж��Ƿ�����ĸ  
	    public boolean IsLetter(){  
	        if((ch>=65 && ch <= 90) || (ch >= 97 && ch <=122)){  
	            return true;  
	        }  
	        return false;  
	    }  
	      
	    //�ж��Ƿ�������  
	    public boolean IsDigit(){  
	        if(ch>=48 && ch <= 57){  
	            return true;  
	        }  
	        return false;  
	    }  
	      
	    //�ж��Ƿ��ǿո�  
	    public boolean IsBC(int ch){  
	        if(ch == 32){  
	            return true;  
	        }  
	        return false;  
	    }  
	      
	    //�����ַ�  
	    public void Concat(char ch){  
	        strToken.append(ch);  
	    }  
	      
	    //�ж��Ƿ��Ǳ�����  
	    public int Reserve(){  
	        for(int i = 0;i < retainWord.length;i++){  
	            if(strToken.toString().equals(retainWord[i])){  
	                return 1;  
	            }  
	        }  
	        if(strToken.length() != 0){  
	            if(strToken.charAt(0)>='0' && strToken.charAt(0)<='9'){  
	                return 3;  
	            }  
	        }  
	          
	        return 2;  
	    }  
	      
	    //  
	    public void Retract(){  
	        code = Reserve();  
	        if(code == 1){  
	            System.out.println("('"+1+"','"+strToken+"')");  
	        }else if(code == 2){  
	            System.out.println("('"+2+"','"+strToken+"')");  
	        }  
	        else if(code == 3){  
	            System.out.println("('"+3+"','"+strToken+"')");  
	        }  
	        strToken.delete(0, strToken.length());  
	    }  
	      
	    /**  
	     * ��ȡ�ļ�  
	     */  
	    public void scanner(){  
	        BufferedReader br;  
	        try {  
	            br = new BufferedReader(new FileReader("text.txt"));  
	            while((ch = br.read()) != -1){  
	                //System.out.println("======="+(char)ch);  
	                if(IsBC(ch) == false){  
	                    if(IsLetter()){  
	                        if(IsLetter() == true || IsDigit() == true){  
	                            Concat((char) ch);  
	                        }  
	                    }else if(IsDigit() == true){  
	                        Concat((char)ch);  
	                    }else if(IsDigit()){  
	                        Concat((char) ch);  
	                    }else if(ch == 61){  
	                        if((strToken.length() != 0 )&& (strToken.charAt(0) == '=')){  
	                            strToken.append((char)ch);  
	                            System.out.println("('"+4+"','"+strToken+"')");  
	                            strToken.delete(0, strToken.length());  
	                        }else{  
	                            strToken.append((char)ch);  
	                        }  
	                    }else if(ch == 43){  
	                        Retract();  
	                        System.out.println("('"+4+"','"+(char) ch+"')");  
	                    }else if(ch == 45){  
	                        Retract();  
	                        System.out.println("('"+4+"','"+(char) ch+"')");  
	                    }else if(ch == 42){  
	                        Retract();  
	                        System.out.println("('"+4+"','"+(char) ch+"')");  
	                    }else if(ch == 47){  
	                        Retract();  
	                        System.out.println("('"+4+"','"+(char) ch+"')");  
	                    }else if((char) ch == ';'){  
	                        Retract();  
	                        System.out.println("('"+5+"','"+(char) ch+"')");  
	                    }else if((char) ch == '('){  
	                        Retract();  
	                        System.out.println("('"+5+"','"+(char) ch+"')");  
	                    }else if((char) ch == ')'){  
	                        Retract();  
	                        System.out.println("('"+5+"','"+(char) ch+"')");  
	                    }else if((char) ch == '{'){  
	                        Retract();  
	                        System.out.println("('"+5+"','"+(char) ch+"')");  
	                    }else if((char) ch == '}'){  
	                        Retract();  
	                        System.out.println("('"+5+"','"+(char) ch+"')");  
	                    }else if((char) ch == ','){  
	                        Retract();  
	                        System.out.println("('"+5+"','"+(char) ch+"')");  
	                    }  
	                      
	                }else{  
	                    Retract();  
	                }  
	                  
	            }  
	        } catch (FileNotFoundException e1) {  
	            // TODO Auto-generated catch block  
	            e1.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    public static void main(String[] args) {  
	        Compile2 compile2 = new Compile2();  
	        compile2.scanner();  
	    }  
	  
	}  


