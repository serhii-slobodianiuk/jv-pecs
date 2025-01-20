package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    @Override
    public List<T> getAll(Class<? extends T> type) {
        MachineProducer<? extends T> machineProducer;

        if (type == Bulldozer.class) {
            machineProducer = (MachineProducer<? extends T>) new BulldozerProducer();
        } else if (type == Excavator.class) {
            machineProducer = (MachineProducer<? extends T>) new ExcavatorProducer();
        } else if (type == Truck.class) {
            machineProducer = (MachineProducer<? extends T>) new TruckProducer();
        } else {
            return Collections.emptyList();
        }
        return (List<T>) machineProducer.get();
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
