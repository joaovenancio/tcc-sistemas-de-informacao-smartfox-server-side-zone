package br.ufsc.inf.leb;

import com.smartfoxserver.v2.core.ISFSEvent;
import com.smartfoxserver.v2.core.SFSEventParam;
import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.variables.RoomVariable;
import com.smartfoxserver.v2.entities.variables.SFSRoomVariable;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.extensions.BaseServerEventHandler;
import com.smartfoxserver.v2.extensions.SFSExtension;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MikeHelpMeExtension extends SFSExtension {

    @Override
    public void init() {
        //General configuration:
        getApi().getSystemScheduler().resizeThreadPool(10);
        //Event Handlers:
        this.addEventHandler(SFSEventType.ROOM_ADDED, RoomAddedEventHandler.class);
    }

}
