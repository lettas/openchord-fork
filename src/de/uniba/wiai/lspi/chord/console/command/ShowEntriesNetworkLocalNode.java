package de.uniba.wiai.lspi.chord.console.command;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Set;

import de.uniba.wiai.lspi.chord.com.Entry;
import de.uniba.wiai.lspi.chord.com.local.ChordImplAccess;
import de.uniba.wiai.lspi.chord.com.local.Registry;
import de.uniba.wiai.lspi.chord.com.local.ThreadEndpoint;
import de.uniba.wiai.lspi.chord.data.ID;
import de.uniba.wiai.lspi.chord.data.URL;
import de.uniba.wiai.lspi.chord.service.Chord;
import de.uniba.wiai.lspi.chord.service.impl.ChordImpl;
import de.uniba.wiai.lspi.util.console.Command;
import de.uniba.wiai.lspi.util.console.ConsoleException;

public class ShowEntriesNetworkLocalNode extends Command {
	/**
	 * The name of this {@link Command}.
	 */
	public static final String COMMAND_NAME = "entriesNL";

	public ShowEntriesNetworkLocalNode(Object[] toCommand, PrintStream out) {
		super(toCommand, out);
	}

	@Override
	public void exec() throws ConsoleException {
		Chord chord = ((RemoteChordNetworkAccess) this.toCommand[1]).getChordInstance();
		Map<ID, Set<Entry>> entries = ((ChordImpl)chord).getEntries();
		
		for(java.util.Map.Entry<ID, Set<Entry>> e : entries.entrySet()) {
			this.out.println(e.getValue());
		}
	}

	@Override
	public void printOutHelp() {

	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
