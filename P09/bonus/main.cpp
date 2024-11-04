#include "timer.h"

int main(int argc, char* argv[]) {
    if (argc != 4) {
        std::cerr << "usage: timer <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds = std::stoi(argv[3]);

        Timer timer(hours, minutes, seconds);
        std::cout << "\nEnter 'q' to quit.\n\n";

        std::string input;
        while (input != "q") {
            std::cout << "Remaining time is now ";
            timer.print();
            std::cout << "\n";
            std::getline(std::cin, input);
            timer.tic();
        }
    } catch (const std::out_of_range& e) {
        std::cerr << e.what() << std::endl;
        return -2;
    } catch (const std::invalid_argument&) {
        std::cerr << "Invalid input" << std::endl;
        return -1;
    } catch (const std::runtime_error& e) {
        std::cout << e.what() << std::endl;

    return 0;
}
