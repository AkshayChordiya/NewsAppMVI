# NewsApp 🗞️
[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/AkshayChordiya//blob/master/LICENSE)

The news app is based upon [NewsSampleMVVM](https://github.com/AkshayChordiya/android-arch-news-sample) but showcases MVI architecture pattern
combined with power of [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), thanks to [Roxie library](https://github.com/ww-tech/roxie)

## What's the app about?
It's a simple news app 🗞️which uses [NewsAPI](https://newsapi.org/) to fetch top news headlines from the API.
The main aim of this app is to show how MVI helps in managing state combined with power of [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) and [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) to make our lives easier. 

The idea is to add new features With time to build a full-fledge app while making it easier to understand the codebase.

## Steps to run 🏃
- Go to [NewsAPI](https://newsapi.org/) and generate an API key (It's only 2 steps!)
- Create new file -> `credentials.properties`
- Add the API key as shown below:
`
NEWS_API_KEY = "YOUR_API_KEY"
`
- Build and run the app
- Enjoyyyyy 🎉

## Components used
- Architecture Components [ViewModel, LiveData, Lifecycle]
- Roxie library for MVI implementation
- Dagger for Dependency Injection

## Dependency Graph 🔪

The following diagram shows the dependecy graph of the app.

<img alt="News App Dependency Graph" height="450px" src="https://raw.githubusercontent.com/AkshayChordiya/NewsAppMVI/master/art/dependency-graph.png" />

Generated by [Daggraph](https://github.com/dvdciri/daggraph)

## Architecture

The app uses **uni-directional** flow of state of the app<sup>1</sup> to have predictable **state machine** style architecture. It's inspired by MVVM and MVI hence it uses the following MVVM architecture while leveraging state management with MVI.

![Architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Data flow<sup>1</sup>

The uni-directional pipeline for the flow of state. 

Source: [Building MVI apps with Roxie](https://proandroiddev.com/unidirectional-data-flow-with-roxie-bec546c18598)

![Data flow](https://raw.githubusercontent.com/AkshayChordiya/NewsAppMVI/master/art/mvi-architecture.png)

## Testing

Super important and all the test cases will come soon.

--------------------

## Screenshots

<img alt="NewsApp Main Page" height="450px" src="https://raw.githubusercontent.com/AkshayChordiya/NewsAppMVI/master/art/screen-news-list.png" />

--------------------

## Learn Architecture Components 📖
Trying to learn the new Architecture Components? I have wrote a series of articles to understand Android Architecture Components. Feel free to check it out to learn more.

- [Introduction to Architecture Components](https://medium.com/@aky/introduction-to-android-architecture-components-22b8c84f0b9d)
- [Exploring ViewModel Architecture component](https://medium.com/@aky/exploring-viewmodel-architecture-component-5d60828172f9)
- [Exploring LiveData Architecture component](https://medium.com/@aky/exploring-livedata-architecture-component-f9375d3644ee)
- [Exploring Room Architecture component](https://medium.com/@aky/exploring-room-architecture-component-6db807094241)

- [Building Modern Android Apps with Architecture Guidelines](https://medium.com/@aky/building-modern-apps-using-the-android-architecture-guidelines-3238fff96f14)

### Extra - Caster.io Course and Podcast
- [Android Architecture Components - A Deep Dive - Caster.io](https://caster.io/courses/android-architecture-components-deep-dive) 📺
- [Android Architecture Components Podcast on Fragmented](http://fragmentedpodcast.com/episodes/115/) 🎤

--------------------

## Contributing 💁

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for contributions.

## License

    The MIT License (MIT)
    
    Copyright (c) 2019 Akshay Chordiya
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
