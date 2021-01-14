import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

// Main class should be named 'Solution'
class PhonePeCode {
        public static void main(String[] args) {
                TriggerEvents triggerEvents = new TriggerEvents();

                triggerEvents.configureEvents(EventType.CPU, 5, 5);
                triggerEvents.configureEvents(EventType.RAM, 3, 3);

                for(int i = 0; i < 10; i++) {
                        triggerEvents.sendEvent(EventType.CPU, "cpu overheating");
                        triggerEvents.sendEvent(EventType.RAM, "ram filling");

                        try {
                                Thread.sleep(1000);
                        } catch(InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
}

enum EventType {
        CPU ("CPU"),
        RAM ("RAM"),
        ROM ("ROM"),
        EXTERNAL ("EXTERNAL");

        private final String name;

        EventType(String name) {
                this.name = name;
        }
}

class TriggerEvents {
        private List<EventConfig> eventConfigList;
        private AlertProcessing alertProcessing;

        public TriggerEvents() {
                eventConfigList = new ArrayList<>();
                alertProcessing = new AlertProcessing();
        }

        public void configureEvents(EventType eventType, int windowInMinutes, int alertCount) {
                EventConfig eventQueueExist = checkIfEventQueueExists(eventType);

                if(eventQueueExist == null) {
                        EventConfig eventConfig = new EventConfig(eventType, windowInMinutes, alertCount);

                        eventConfigList.add(eventConfig);
                }
        }

        private EventConfig checkIfEventQueueExists(EventType eventType) {
                for(EventConfig eventConfig : eventConfigList) {
                        if(eventConfig.getEventType().equals(eventType)) {
                                return eventConfig;
                        }
                }

                return null;
        }

        public void sendEvent(EventType eventType, String message) {
                EventConfig eventQueueExist = checkIfEventQueueExists(eventType);

                if(eventQueueExist != null) {
                        if(new EventHandler(eventQueueExist).registerEvent()) {
                                alertProcessing.sendAlert(message, eventType);
                        }
                } else {
                        System.out.println("Event configuration not done");
                }
        }
}

class AlertProcessing {
        public AlertProcessing() {}

        public void sendAlert(String message, EventType eventType) {
                System.out.println ("########Alert#########");
                System.out.println("EventType : " + eventType.toString() + " |  TimeStamp : " + new Date());
                System.out.println("eventType : " + eventType.toString() + "message : " + message);
        }
}

class EventConfig {
        private EventType eventType;
        private int windowInMinutes;
        private int alertCount;
        private Queue<Long> queue;

        public EventConfig(EventType eventType, int windowInMinutes, int alertCount) {
                this.eventType = eventType;
                this.windowInMinutes = windowInMinutes;
                this.alertCount = alertCount;
                queue = new LinkedList<>();
        }

        public Queue<Long> getQueue() {
                return this.queue;
        }

        public void setQueue(Queue<Long> queue) {
                this.queue = queue;
        }

        public int getWindowInMinutes() {
                return this.windowInMinutes;
        }

        public int getAlertCount() {
                return this.alertCount;
        }

        public EventType getEventType() {
                return this.eventType;
        }
}

class EventHandler {
        private EventConfig eventConfig;

        public EventHandler(EventConfig eventConfig) {
                this.eventConfig = eventConfig;
        }

        public boolean registerEvent() {
                System.out.println("EventType : " + eventConfig.getEventType().toString() + " | TimeStamp : " + new Date());

                if(!eventConfig.getQueue().isEmpty()) {
                        while((System.currentTimeMillis() - eventConfig.getQueue().peek()) > eventConfig.getWindowInMinutes()*1000) {
                                eventConfig.getQueue().poll();
                        }
                }

                eventConfig.getQueue().add(System.currentTimeMillis());

                if(eventConfig.getQueue().size() >= eventConfig.getAlertCount()) {
                        return true;
                }

                return false;
        }
}