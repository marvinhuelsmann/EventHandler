package de.marvhuelsmann.eventhandler.anotations.events;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface onJoin {
}
