/**
 * 
 */

package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//import java.lang.String;


/**
 * @author zoe
 *
 */
public class ServerCode {

	/**
	 * @param args
	 */
	
	public static int portNo = 3333;//���ö˿ں�
	
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(portNo);
		System.out.println("The Server is start:" + s);
		
		Socket socket = s.accept();//������ֱ���ͻ�������
		
		try 
		{
			System.out.println("Accept the Client:" + socket);
			//����IO���
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			while (true)
			{
				String str = in.readLine();
				if (str.equals("byebye"))  break;
				
				System.out.println("In Server reveived the info:" + str);
				out.println(str);
			}
		}
			finally
			{
				System.out.println("close the Server socket and the io");
				socket.close();
				s.close();
			}

	}

}
