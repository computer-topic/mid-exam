List<Module> moduleDependencies = module.getDependSubsystems();
SubSysMod ourSubSystem = subSysMod.getSubSystem();

if (moduleDependencies.contains(ourSubSystem))