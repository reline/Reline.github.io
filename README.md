# [Reline.github.io](https://reline.github.io)
My professional website

## Dependencies
- [Node](https://nodejs.org/en/)
- [NPM](https://www.npmjs.org/)
- [Gulp](https://github.com/gulpjs/gulp/tree/4.0)
- [Material Design Lite generator](https://www.npmjs.com/package/generator-mdl)
- [Angular2 Material Design Lite](https://www.npmjs.com/package/angular2-mdl)

Install all the npm dependencies with:

```sh
npm install
```

## Running the site

To run the site:

```sh
gulp serve
```

## Development

Keep running `gulp serve` in your terminal while developing new code to make
sure your browser stays up to date with your file changes.

Once done, build your production version with

```sh
gulp build
```

## Gulp tasks

`serve` :     Render a debug version of your project in your browser and
              start watching over file changes.

`build` :       Build a distribution version of the website in a
                `dist` folder.

`versionify` :  Update your `package.json` version number.

`serveDist` :   Build a distribution version of the website in a `dist` and
                render it a browser.
