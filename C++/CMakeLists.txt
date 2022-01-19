cmake_minimum_required(VERSION 3.3)
project(test_build)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(BUILD_1 main)
set(SOURCE_FILES_1 template/test.cpp)
add_executable(${BUILD_1} ${SOURCE_FILES_1})

set(BUILD_2 main_2)
set(SOURCE_FILES_2 day1/SortArray.cpp)
add_executable(${BUILD_2} ${SOURCE_FILES_2})
add_executable(test template/test.cpp)
add_executable( BestTimeToBuyAndSellStock "day0/ BestTimeToBuyAndSellStock.cpp")
add_executable(Search2DMatrix day0/Search2DMatrix.cpp)

add_executable(SearchInSortedRotatedArray day1/SearchInSortedRotatedArray.cpp)
add_executable(3Sum day1/3Sum.cpp)