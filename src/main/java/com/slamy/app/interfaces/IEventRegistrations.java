package com.slamy.app.interfaces;

import java.util.List;

public interface IEventRegistrations {
    public List<IEvent> getAllEvents();
    public IEvent getEventById(Long id);
    public String registrationForEvent();
}
