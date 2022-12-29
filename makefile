# Specify the main class for the project
MAIN_CLASS = Main

# Compile the project

build:
	@javac -d bin $(MAIN_CLASS).java

# Run the project
run: 
	@java -cp bin $(MAIN_CLASS)

# Clean the project
clean:
	rm -rf bin

# Compile and run the project
all: build run clean
