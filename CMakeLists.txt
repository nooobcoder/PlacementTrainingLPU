cmake_minimum_required(VERSION 3.19)
project(PlacementTrainingLPU)

set(CMAKE_CXX_STANDARD 14)

add_executable(PlacementTrainingLPU
        C++/day0/Search2DMatrix.cpp
        "C++/day1/ BestTimeToBuyAndSellStock.cpp"
        C++/day1/SortArray.cpp)
