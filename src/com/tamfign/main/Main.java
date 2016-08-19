package com.tamfign.main;

import java.io.IOException;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import com.tamfign.configuration.Configuration;
import com.tamfign.connection.ConnectController;

public class Main {

	public static void main(String[] args) {
		ServerArguments arguments = new ServerArguments();
		CmdLineParser parser = new CmdLineParser(arguments);
		Configuration config = null;
		ConnectController controller = null;

		try {
			parser.parseArgument(args);
			config = Configuration.getInstance(arguments);
			controller = ConnectController.getInstance(config);
			controller.run();
		} catch (CmdLineException e) {
			System.err.println("Example: java -jar server.jar -n serverid -l servers_conf");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
