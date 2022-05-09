package _00_exercise.extra_ex_2.model;

public class MovieShow {
    private String showCode;
    private String movieName;
    private String showDate;
    private int tickets;

    public MovieShow(String showCode, String movieName, String showDate, int tickets) {
        this.showCode = showCode;
        this.movieName = movieName;
        this.showDate = showDate;
        this.tickets = tickets;
    }

    public MovieShow(String[] strArr) {
        this.showCode = strArr[0];
        this.movieName = strArr[1];
        this.showDate = strArr[2];
        this.tickets = Integer.parseInt(strArr[3]);
    }

    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return  showCode + ',' +
                movieName + ',' +
                showDate + ',' +
                tickets;
    }

    public String getInfo() {
        return  "MOVIE SHOW \n" +
                "Show Code: " + showCode + '\n' +
                "Show Name: " + movieName + '\n' +
                "Show Date: " + showDate + '\n' +
                "Show Tickets: " + tickets;
    }
}
