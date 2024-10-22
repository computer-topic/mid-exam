List<SubSystem> dependSubsystems = module.getDependSubsystems();
String subSystem = susSysMod.getSubSystem();
if(dependSubsystems.contains(subSysMod)) {
  ...
}