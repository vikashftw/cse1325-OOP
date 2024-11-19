#include "date.h"
#include <fstream>
#include <sstream>
#include <map>

typedef double Temp;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "usage: " << argv[0] << " <data file>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream file(filename);

    if (!file) {
        std::cerr << "Can't open input file " << filename << std::endl;
        return 1;
    }

    std::map<Date, Temp> temps;

    std::string line;
    while (std::getline(file, line)) {
        std::stringstream ss(line);
        std::string continent, country, state, region;

        std::getline(ss, continent, ',');
        std::getline(ss, country, ',');
        std::getline(ss, state, ',');
        std::getline(ss, region, ',');

        std::getline(ss, line, ',');
        int month = std::stoi(line);

        std::getline(ss, line, ',');
        int day = std::stoi(line);

        std::getline(ss, line, ',');
        int year = std::stoi(line);

        std::getline(ss, line, ',');
        double temperature = std::stod(line);

        Date date(year, month, day);
        temps[date] = temperature;
    }

    file.close();

    while (true) {
        Date start_date, end_date;

        std::cout << "Starting date to list (year/month/day): ";
        if (!(std::cin >> start_date)) {
            break;
        }

        if (temps.find(start_date) == temps.end()) {
            std::cerr << start_date << " is not in the database!" << std::endl;
            continue;
        }

        std::cout << "Ending   date to list (year/month/day): ";
        if (!(std::cin >> end_date)) {
            break; 
        }

        if (end_date < start_date) {
            std::cerr << end_date << " is earlier than " << start_date << "!" << std::endl;
            continue;
        }

        for (auto it = temps.lower_bound(start_date); it != temps.end() && it->first <= end_date; ++it) {
            std::cout << it->first << "   "
                      << std::fixed << std::setprecision(1) << it->second << std::endl;
        }
    }

    return 0;
}
