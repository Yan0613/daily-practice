package TOOLS;
import java.io.IOException;

public class PythonExecutor {
    private static String PATH; 

    public PythonExecutor(String function,String method){
        if(function instanceof String && method instanceof String){
            this.PATH = "example/"+function +"/" +method+"/";
        }
        else{
            System.out.println("请输入正确的功能和方法");
        }
    }
    public static void exc(String file) throws IOException {
        String exc_path = PATH + file;
        ProcessBuilder pb = new ProcessBuilder("python", exc_path);
        pb.inheritIO();
        pb.redirectErrorStream(true);
        Process process = pb.start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
