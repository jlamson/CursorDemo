# Example Interview Project

Welcome to the this example assessment! This project is a starting point for the below problem.

## The Project

This project will serve as a starting point in the interview process. Once this project has been evaluated by our engineering team, you may be invited for a full panel interview with various members of the team. At the full panel interview, we'll review this project with you and ask you to enhance it with a new set of requirements.

As you tackle this problem, keep in mind we'll be looking for the following:

* Code structure and software architecture principles
* Ability to navigate ambiguous requirements
* Your unique strengths as a software engineer

At the end of this session, make sure you push what you've completed and your interview has access to your repo.

## AI Usage Policy

**AI assistance is allowed** for this project. Whether you choose to use AI tools or not is entirely up to you - both approaches are valid.

### Documentation Requirement

If you choose to use AI tools, please document your usage in the `AI_USE.md` file in the root of this project. This documentation should include:

* **What AI tools you used** (e.g., Cursor, GitHub Copilot, ChatGPT, Claude, etc.)
* **Specific tasks you used AI for** (e.g., boilerplate code, debugging, architecture decisions, etc.)
* **Key prompts or questions you asked** the AI
* **How you evaluated and modified AI-generated code**
* **Your reasoning for when to use AI vs. writing code yourself**

### Cursor Users

If you're using Cursor, you'll be prompted to enable automatic AI usage logging when you first start the project. This can handle the documentation for you, but you're welcome to supplement it with additional context.

### Other AI Tools

For other AI tools, please manually maintain the `AI_USE.md` file throughout your development process. Be specific about what you asked for and how you used the responses.

### Why We Care

If you use AI tools, we'll discuss your usage during the interview to understand:
* How you collaborate with AI tools
* Your ability to evaluate and improve AI-generated code
* Your decision-making process for when to use AI assistance

This helps us understand your development approach and ensures we can have meaningful technical discussions about your implementation choices.

## The Problem

We would like you to build a simple app for searching for movies and TV shows powered by the [TMDB API](https://developer.themoviedb.org/docs/getting-started).

This app should support:

* Displaying an initial list of popular movies based on the `movie/popular` endpoint, displaying the following information for each movie:
  * Title
  * Year of release
  * Poster image
* Allowing users to search for movies with the `search/movie` endpoint, displaying the following information for each movie:
  * Title
  * Year of release
  * Poster image
* Selecting a movie from either list to view additional details about it, including:
  * Title
  * Year of release
  * Poster image
  * Overview
  * List of production companies that worked on the movie

## Architecture Overview

This implementation follows **modern Android architecture patterns** with clean separation of concerns:

* **MVVM + Repository Pattern**: ViewModels manage UI state with StateFlow, Repository handles data operations
* **Jetpack Compose**: Declarative UI with Material 3 design system
* **Dependency Injection**: Hilt for compile-time DI with proper scoping
* **Reactive Programming**: Flow-based data streams with Resource wrapper for loading/error states
* **Navigation**: Compose Navigation with type-safe argument passing
* **Networking**: Retrofit + OkHttp with Gson serialization and logging interceptor
* **Security**: API keys managed via `secrets.properties` (gitignored, following Android guidelines)

**Key architectural decisions**: Single-activity pattern, unidirectional data flow, separation of data/domain/presentation layers, and proper error handling throughout the stack.
