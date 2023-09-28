#include <cstdio>

#include <base.h>
#include <intermediate.h>

int intermediate (int argc, char * argv[])
{
    return base(argc,argv) + std::printf(", World!");
}