package Control;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;

public class Restart {
	
	public static void restartApplication( Runnable runBeforeRestart) throws IOException {
	    try {

	        String java = System.getProperty("java.home") + "/bin/java";

	        List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
	        StringBuffer vmArgsOneLine = new StringBuffer();
	        for (String arg : vmArguments) {

	            if (!arg.contains("-agentlib")) {
	                vmArgsOneLine.append(arg);
	                vmArgsOneLine.append(" ");
	            }
	        }

	        final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);
	        String[] mainCommand = System.getProperty("sun.java.command").split(" ");

	        if (mainCommand[0].endsWith(".jar")) {
	            cmd.append("-jar " + new File(mainCommand[0]).getPath());
	        } else {
	            cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" " + mainCommand[0]);
	        }
	        for (int i = 1; i < mainCommand.length; i++) {
	            cmd.append(" ");
	            cmd.append(mainCommand[i]);
	        }
	        Runtime.getRuntime().addShutdownHook(new Thread() {
	            @Override
	            public void run() {
	                try {
	                    Runtime.getRuntime().exec(cmd.toString());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	        System.exit(0);
	    } catch (Exception e) {
	    	//throw new IOException("Error while trying to restart the application", e);
	    }
	}
	   
}
