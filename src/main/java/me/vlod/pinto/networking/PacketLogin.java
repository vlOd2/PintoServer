package me.vlod.pinto.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import me.vlod.pinto.Utils;

public class PacketLogin implements Packet {
    public byte protocolVersion;
    public String name;
    public String passwordHash;
	
    public PacketLogin() { }
    
    public PacketLogin(byte protocolVersion, 
    		String name, String passwordHash) {
    	this.protocolVersion = protocolVersion;
    	this.name = name;
    	this.passwordHash = passwordHash;
    }
    
	@Override
	public void read(DataInputStream stream) throws IOException {
		this.protocolVersion = (byte) stream.read();
		this.name = Utils.readUTF8StringFromStream(stream);
		this.passwordHash = Utils.readUTF8StringFromStream(stream);
	}
	
	@Override
	public void write(DataOutputStream stream) throws IOException {
		stream.write(this.protocolVersion);
		Utils.writeUTF8StringToStream(stream, this.name);
		Utils.writeUTF8StringToStream(stream, this.passwordHash);
	}

	@Override
	public int getID() {
		return 0;
	}
}
