class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer startfloor = calendar.floorKey(start);
          Integer startceil = calendar.ceilingKey(start);
        //System.out.println(startfloor + " "+ startceil);
        
        if ((startfloor == null || calendar.get(startfloor) <= start) &&
                (startceil == null || end <= startceil)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}