package me.vlod.pinto.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import me.vlod.pinto.Utils;

public class PacketRemoveContact implements Packet {
    public String contactName;

    public PacketRemoveContact() { }
    
    public PacketRemoveContact(String contactName) {
    	this.contactName = contactName;
    }
    
	@Override
	public void read(DataInputStream stream) throws IOException {
		this.contactName = Utils.readUTF8StringFromStream(stream);
	}
	
	@Override
	public void write(DataOutputStream stream) throws IOException {
		Utils.writeUTF8StringToStream(stream, this.contactName);
	}

	@Override
	public int getID() {
		return 7;
	}
}
