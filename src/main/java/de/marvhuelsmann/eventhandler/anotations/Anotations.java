package de.marvhuelsmann.eventhandler.anotations;

import de.marvhuelsmann.eventhandler.anotations.events.onJoin;
import de.marvhuelsmann.eventhandler.anotations.events.onMove;
import lombok.Getter;

@Getter
public enum Anotations {

    ONJOIN(onJoin.class, "OnJoin"),
    ONMOVE(onMove.class, "onMove"),
    ONCOMMAND(onMove.class, "onCommand");

    private final Class type;
    private final String name;

    Anotations(Class type, String name) {
        this.type = type;
        this.name = name;
    }


}
