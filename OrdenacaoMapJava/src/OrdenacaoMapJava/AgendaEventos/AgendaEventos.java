package OrdenacaoMapJava.AgendaEventos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Eventos>agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao){
        agendaEventosMap.put(data, new Eventos(nomeEvento, nomeAtracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Eventos>eventosTreeMap = new TreeMap<>(agendaEventosMap);
        for(Map.Entry<LocalDate, Eventos>entry:eventosTreeMap.entrySet()){
            LocalDate dataEvento = entry.getKey();
            Eventos evento = entry.getValue();
            System.out.println("Data: " + dataEvento + ", Evento: " + evento.getNomeEvento() + ", Atração: " + evento.getNomeAtracao());
        }
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Eventos proximoEvento = null;
        for (Map.Entry<LocalDate, Eventos> entry : agendaEventosMap.entrySet()) {
          LocalDate dataEvento = entry.getKey();
          if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
            proximaData = dataEvento;
            proximoEvento = entry.getValue();
            break;
          }
        }
        if (proximoEvento != null) {
          System.out.println("O próximo evento: " + proximoEvento.getNomeEvento() + " acontecerá na data " + proximaData);
        } else {
          System.out.println("Não há eventos futuros na agenda.");
        }
      }

    

    
}
