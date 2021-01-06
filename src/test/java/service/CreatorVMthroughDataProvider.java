package service;

import businessobjects.VirtualMachine;

public class CreatorVMthroughDataProvider {

    private static final String valueInstance = "4";
    private static final String valueOperatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String desiredResultVMClass = "Regular";
    private static final String valueSeries = "n1";
    private static final String desiredResultInstanceType = "n1-standard-8";
    private static final String desiredResultLocalSSD = "2x375";
    private static final String desiredResultRegion = "Frankfurt";
    private static final String desiredResultCommitmentTerm = "1 Year";

    public static VirtualMachine getVirtualMachineWithSelectedParametersAqa() {
        VirtualMachine vm = new VirtualMachine();
        vm.setValueInstance(valueInstance);
        vm.setValueOperatingSystem(valueOperatingSystem);
        vm.setDesiredResultVMClass(desiredResultVMClass);
        vm.setValueSeries(valueSeries);
        vm.setDesiredResultInstanceType(desiredResultInstanceType);
        vm.setDesiredResultLocalSSD(desiredResultLocalSSD);
        vm.setDesiredResultRegion(desiredResultRegion);
        vm.setDesiredResultCommitmentTerm(desiredResultCommitmentTerm);
        return vm;
    }
}
