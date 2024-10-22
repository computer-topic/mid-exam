List<SubSystem> dependSubsystems = module.getDependSubsystems();
String subSystem = susSysMod.getSubSystem();
if(dependSubsystems.contains(subSysMod)) {
  ...
}

// 교재에서 구조는 동일하나 변수명에 차이가 있음
// ArrayList moduleDependees = module.getDependSubsystems();
// String ourSubSystem = subSysMod.getSubSystem();
// if (moduleDependees.contains(ourSubSystem))