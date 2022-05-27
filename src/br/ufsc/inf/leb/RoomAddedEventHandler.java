package br.ufsc.inf.leb;

import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.variables.RoomVariable;
import com.smartfoxserver.v2.entities.variables.SFSRoomVariable;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RoomAddedEventHandler extends BaseServerEventHandler {
    @Override
    public void handleServerEvent(ISFSEvent isfsEvent) throws SFSException {
        // reference to the created room
        Room room = (Room) isfsEvent.getParameter(SFSEventParam.ROOM);

        RoomVariable turn = new SFSRoomVariable("turn", "LOBBY");
        turn.setGlobal(true);
        turn.setPrivate(true);

        RoomVariable timer = new SFSRoomVariable("timer", 0);
        timer.setGlobal(false);
        timer.setPrivate(true);

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        RoomVariable date = new SFSRoomVariable("date", timeStamp );
        date.setPrivate(true);

        getApi().setRoomVariables(null, room, Arrays.asList(turn, timer, date));
    }
}
