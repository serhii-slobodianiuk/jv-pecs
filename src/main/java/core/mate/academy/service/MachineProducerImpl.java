package core.mate.academy.service;

import java.util.List;

public class MachineProducerImpl <Machine> implements MachineProducer<Machine>{
    @Override
    public List<Machine> get() {
        return List.of();
    }
}
