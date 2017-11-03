/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainstations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author jim.stewart
 */
public class TrainStations {

    private final InputReader reader;
    private final OutputWriter writer;
    private ArrayList<Station> stations;

    public TrainStations(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.stations = new ArrayList<>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        OutputWriter writer = new OutputWriter(System.out);
        new Thread(null, new Runnable(){
            @Override
            public void run(){
                new TrainStations(reader, writer).run();
            }
        }, "1", 1<<26).start();
        writer.writer.flush();
    }

    public void run(){
        int[][] input = new TrainStations(reader, writer).input();
        for(int i=0;i<input.length-1;i++){
            int[] line = input[i];
            int stationNumber = line[0];
            int connectedStationNumber = line[1];
            
            stations = fillAndAdd(stationNumber, stations);
            Station station = stations.get(stationNumber);
            stations = fillAndAdd(connectedStationNumber, stations);
            Station connectedStation = stations.get(connectedStationNumber);
            station.connectedStations.add(connectedStationNumber);
            connectedStation.connectedStations.add(stationNumber);
        }
        int[] startEnd = input[input.length-1];
        int start = startEnd[0];
        int end = startEnd[1];
        ArrayList<Integer> path = findPath(stations, start, end);
        System.out.println(path);
    }
    
    private ArrayList<Integer> findPath(ArrayList<Station> stations, int start, int end){
        ArrayList<Integer> path = new ArrayList<>();
        //TODO: write your code to find the shortest path
        return path;
    }
    
    private ArrayList<Station> fillAndAdd(int stationNumber, ArrayList<Station> stations){
        if(stations.size()<=stationNumber){
            for(int i=stations.size();i<=stationNumber;i++){
                stations.add(new Station(i));
            }
        }
        return stations;
    }
    /**
     * <p>Input will begin with the number of stations on the
     * first line, followed by a line for each station containing a 
     * station number and the station it's connected to. For example: </p>
     * <p>3<br />
     * 0 1
     * 0 2
     * 1 2<br />
     * </p>
     * @return a two dimensional array of each line of input
     */
    private int[][] input(){
        int[][] rtrn;
        int numberOfStations = reader.nextInt();
        rtrn = new int[numberOfStations][2];
        for(int i=0;i<numberOfStations;i++){
            rtrn[i][0] = reader.nextInt();
            rtrn[i][1] = reader.nextInt();
        }
        return rtrn;
    }
    
    /**
     * Station contains a station number and a list of integers for
     * connected stations. 
     */
    class Station{
        private int stationNumber;
        private ArrayList<Integer> connectedStations;
        public Station(int stationNumber){
            this.stationNumber=stationNumber;
            this.connectedStations= new ArrayList<>();
        }
        
        public int getStationNumber(){
            return stationNumber;
        }
        public void setStationNumber(int n){
            stationNumber = n;
        }
        public ArrayList<Integer> getConnectedStations(){
            return connectedStations;
        }
        public void addConnectedStations(int stationNumber){
            connectedStations.add(stationNumber);
        }
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static class OutputWriter {
        public PrintWriter writer;

        OutputWriter(OutputStream stream) {
            writer = new PrintWriter(stream);
        }

        public void printf(String format, Object... args) {
            writer.print(String.format(Locale.ENGLISH, format, args));
        }
    }

}
