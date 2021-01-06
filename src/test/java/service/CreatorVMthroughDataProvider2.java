package service;

import businessobjects.VirtualMachine;

public class CreatorVMthroughDataProvider2 {

    private static final String valueInstance = "1";
    private static final String valueOperatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String desiredResultVMClass = "Regular";
    private static final String valueSeries = "n2";
    private static final String desiredResultInstanceType = "n2-standard-8";
    private static final String desiredResultLocalSSD = "1x375";
    private static final String desiredResultRegion = "Iowa";
    private static final String desiredResultCommitmentTerm = "1 Year";

    public static VirtualMachine getVirtualMachineWithSelectedParametersDev() {
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
