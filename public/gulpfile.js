/*
var gulp = require('gulp'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    rename = require('gulp-rename'),
    sass = require('gulp-ruby-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    browserSync = require('browser-sync').create();
*/
var gulp = require('gulp'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    rename = require('gulp-rename'), 
	less = require("gulp-less");
var DEST = 'build/';
//var NOM_FILE = 'new-custom';

gulp.task('scripts', function() {
    return gulp.src([
        'src/js/helpers/*.js',
        'src/js/*.js',
      ])
      .pipe(concat('custom.js'))
      .pipe(gulp.dest(DEST+'/js'))
      .pipe(rename({suffix: '.min'}))
      .pipe(uglify())
      .pipe(gulp.dest(DEST+'/js'))
      //.pipe(browserSync.stream())
	  ;
});

// TODO: Maybe we can simplify how sass compile the minify and unminify version
/*
var compileSASS = function (filename, options) {
  return sass('src/scss/*.scss', options)
        .pipe(autoprefixer('last 2 versions', '> 5%'))
        .pipe(concat(filename))
        .pipe(gulp.dest(DEST+'/css'))
        .pipe(browserSync.stream());
};

gulp.task('sass', function() {
    return compileSASS('custom.css', {});
});

gulp.task('sass-minify', function() {
    return compileSASS('custom.min.css', {style: 'compressed'});
});

gulp.task('browser-sync', function() {
    browserSync.init({
        server: {
            baseDir: './'
        }//,
        //startPath: './production/index.html'
		
    });
});
*/

gulp.task('compile-less', function () {
    gulp.src('src/less/*.less') // path to your file
    .pipe(less())
    .pipe(gulp.dest(DEST+'/css'))
	.pipe(rename({suffix: '.min'}))
    .pipe(uglify())
    .pipe(gulp.dest(DEST+'/css'));
});

gulp.task('watch', function() {
  // Watch .html files
  //gulp.watch('production/*.html', browserSync.reload);
  
  // Watch .js files
  gulp.watch('src/js/*.js', ['scripts']);
  
  // Watch .less files
  gulp.watch('src/less/*.less', ['compile-less']);
  
  // Watch .scss files
  // gulp.watch('src/scss/*.scss', ['sass', 'sass-minify']);
});

// Default Task
gulp.task('default', ['watch']);
//gulp.task('default', ['browser-sync', 'watch']);