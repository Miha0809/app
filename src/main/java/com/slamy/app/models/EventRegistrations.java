package com.slamy.app.models;

import com.slamy.app.interfaces.IEvent;
import com.slamy.app.interfaces.IEventRegistrations;

import java.util.List;

public class EventRegistrations implements IEventRegistrations {

    @Override
    public List<IEvent> getAllEvents() {
        return null;
    }

    @Override
    public IEvent getEventById(Long id) {
        return null;
    }

    @Override
    public String registrationForEvent() {
        return null;
    }
}
