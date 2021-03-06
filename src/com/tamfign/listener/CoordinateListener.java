package com.tamfign.listener;

import java.net.Socket;

import org.json.simple.JSONObject;

import com.tamfign.command.Command;
import com.tamfign.connection.CoordinateConnector;

public class CoordinateListener extends CommandListener {

	public CoordinateListener(CoordinateConnector connetor, Socket socket) {
		super(connetor, socket);
	}

	@Override
	protected void handleDisconnect() {
		// Do nothing, as assuming that servers won't crash.
	}

	@Override
	protected void handleRequest(String cmdLine) {
		System.out.println("Server: " + cmdLine);
		JSONObject cmdObject = Command.getCmdObject(cmdLine);
		((CoordinateConnector) getConnector()).getMQ().addCmd(new Command(getSocket(), cmdObject, null));
	}
}
